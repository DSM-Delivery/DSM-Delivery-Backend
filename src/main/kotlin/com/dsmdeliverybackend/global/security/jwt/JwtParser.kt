package com.dsmdeliverybackend.global.security.jwt

import com.dsmdeliverybackend.global.exception.ExpiredToken
import com.dsmdeliverybackend.global.exception.InternalServerError
import com.dsmdeliverybackend.global.exception.InvalidToken
import com.dsmdeliverybackend.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser (
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {
    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            when(e) {
                is InvalidClaimException -> throw InvalidToken.Exception
                is ExpiredJwtException -> throw ExpiredToken.Exception
                else -> throw InternalServerError.Exception
            }
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)
        val accountId = claims.subject
        val authDetails = authDetailsService.loadUserByUsername(accountId)

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    companion object val REFRESH_KEY = "refresh"

    fun isNotRefreshToken(token: String): Boolean {
        return !REFRESH_KEY.equals(getClaims(token).get("type").toString())
    }

}