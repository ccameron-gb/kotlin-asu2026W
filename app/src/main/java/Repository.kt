package com.example.kotlin_demo_mobile_app

class Repository<T : Identifiable> {
    private val items = mutableMapOf<String, T>()

    fun get(id: String): T? = items[id]

    fun save(item: T) {
        items[item.id] = item
    }

    fun getAll(): List<T> = items.values.toList()
}