import request from '@/utils/request'

export function userLogin(data) {
  return request({
    url: '/auth/login',
    method: 'post',
    data
  })

  function addBill(data) {
    return request({
      url:'/#/index',
      method:'post',
      data
    })
  }

  function addBill(data) {
    return request({
      url:'/#/index',
      method:'delete',
      data
    })
  }
}

