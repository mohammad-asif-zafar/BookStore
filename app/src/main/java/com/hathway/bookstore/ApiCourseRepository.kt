package com.hathway.bookstore

import com.hathway.bookstore.data.CourseUiModel
import com.hathway.bookstore.repo.CourseRepository

/*class ApiCourseRepository(
    private val api: CourseApi,
    private val dao: CourseDao
) : CourseRepository {

    override suspend fun getCourses(): List<CourseUiModel> {
        val local = dao.getCourses()
        if (local.isNotEmpty()) return local

        val remote = api.getCourses()
        dao.insertCourses(remote)
        return remote
    }
}*/
