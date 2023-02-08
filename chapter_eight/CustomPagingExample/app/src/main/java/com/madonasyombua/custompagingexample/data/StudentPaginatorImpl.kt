package com.madonasyombua.custompagingexample.data

class StudentPaginatorImpl<Key, Student>(
    private val key: Key,
    private inline val loadUpdated: (Boolean) -> Unit,
    private inline val request: suspend (nextKey: Key) -> Result<List<Student>>,
    private inline val nextKey: suspend (List<Student>) -> Key,
    private inline val error: suspend (Throwable?) -> Unit,
    private inline val success: suspend (items: List<Student>, newKey: Key) -> Unit
) : StudentPaginator<Key, Student> {

    private var currentKey = key
    private var stateRequesting = false

    override suspend fun loadNextStudent() {
        if (stateRequesting) {
            return
        }
        stateRequesting = true
        loadUpdated(true)
        val result = request(currentKey)
        stateRequesting = false
        val studentProfiles = result.getOrElse {
            error(it)
            loadUpdated(false)
            return
        }
        currentKey = nextKey(studentProfiles)
        success(studentProfiles, currentKey)
        loadUpdated(false)
    }

    override fun reset() {
        currentKey = key
    }
}