package com.dsmdeliverybackend.domain.user.presentation

import com.dsmdeliverybackend.domain.user.presentation.dto.request.UserSignInRequest
import com.dsmdeliverybackend.domain.user.presentation.dto.request.UserSignUpRequest
import com.dsmdeliverybackend.domain.refresh_token.dto.response.TokenResponse
import com.dsmdeliverybackend.domain.user.presentation.dto.request.UserStarRequest
import com.dsmdeliverybackend.domain.user.service.TokenRefreshService
import com.dsmdeliverybackend.domain.user.service.UserSignInService
import com.dsmdeliverybackend.domain.user.service.UserSignUpService
import com.dsmdeliverybackend.domain.user.service.UserStarAvgService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val signUpService: UserSignUpService,
    private val signInService: UserSignInService,
    private val tokenRefreshService: TokenRefreshService,
    private val userStarAvgService: UserStarAvgService
) {

    @PostMapping("/register")
    fun signUp(@RequestBody request: UserSignUpRequest) {
        signUpService.execute(request)
    }

    @PostMapping("/auth")
    fun signIn(@RequestBody request: UserSignInRequest): TokenResponse {
        return signInService.execute(request)
    }

    @PutMapping("/token")
    fun reIssue(@RequestHeader("REFRESH-TOKEN") refreshToken: String): TokenResponse {
        return tokenRefreshService.execute(refreshToken)
    }

    @PutMapping("/rating")
    fun userRating(@RequestBody request: UserStarRequest) {
        userStarAvgService.execute(request)
    }

}