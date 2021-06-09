package br.com.ls.catalog.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LsCatalogApiApplication

fun main(args: Array<String>) {
	runApplication<LsCatalogApiApplication>(*args)
}
