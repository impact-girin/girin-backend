package com.girin.girinbackend.domain.repository

import com.girin.girinbackend.domain.entity.building.Menu
import org.springframework.data.repository.CrudRepository

interface MenuRepository : CrudRepository<Menu, Long>
