package com.task.sunsporttask.mainScreen.data

class MainRepository(private val dataSource: IMainDataSource) : IMainRepository {
    override suspend fun getUsers(page: Int, numberOfItemPerPage: Int):MainUserResponse {
      return  dataSource.getUsers(page, numberOfItemPerPage)
    }
}