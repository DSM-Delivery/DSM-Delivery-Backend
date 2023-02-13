package com.dsmdeliverybackend.domain.parcel.presentation

import com.dsmdeliverybackend.domain.parcel.presentation.dto.request.CreateParcelRequest
import com.dsmdeliverybackend.domain.parcel.presentation.dto.response.ParcelListResponse
import com.dsmdeliverybackend.domain.parcel.presentation.dto.response.UserListResponse
import com.dsmdeliverybackend.domain.parcel.service.CreateParcelService
import com.dsmdeliverybackend.domain.parcel.service.ParcelInspectionService
import com.dsmdeliverybackend.domain.parcel.service.QueryParcelListService
import com.dsmdeliverybackend.domain.parcel.service.QueryUserListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/courier")
@RestController
class ParcelController(
    private val queryUserListService: QueryUserListService,
    private val createParcelService: CreateParcelService,
    private val queryParcelListService: QueryParcelListService,
    private val parcelInspectionService: ParcelInspectionService
) {

    @GetMapping("/list")
    fun userList(): UserListResponse {
        return queryUserListService.execute()
    }

    @PostMapping("/list")
    fun addParcel(@RequestBody request: CreateParcelRequest) {
        createParcelService.execute(request)
    }

    @GetMapping("/parcel-list")
    fun parcelList(): ParcelListResponse {
        return queryParcelListService.execute()
    }

    @PostMapping("/parcel-list/{parcel-id}")
    fun parcelInspection(@PathVariable("parcel-id") parcelId: UUID) {
        parcelInspectionService.execute(parcelId)
    }

}