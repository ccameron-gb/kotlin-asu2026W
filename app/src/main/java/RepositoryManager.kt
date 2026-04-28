package com.example.kotlin_demo_mobile_app

class RepositoryManager {
    @PublishedApi
    internal val repositories = mutableMapOf<Class<*>, Any>()

    inline fun <reified T : Identifiable> repository(): Repository<T> {
        val key = T::class.java
        @Suppress("UNCHECKED_CAST")
        return repositories.getOrPut(key) { Repository<T>() } as Repository<T>
    }

    inline fun <reified T : Identifiable> save(item: T) {
        repository<T>().save(item)
    }

    inline fun <reified T : Identifiable> get(id: String): T? {
        return repository<T>().get(id)
    }
}