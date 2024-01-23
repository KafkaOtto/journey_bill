import request from '@/utils/request'

export function userLogin(data) {
  return request({
    url: '/auth/login',
    method: 'post',
    data
  })

  function getBills(userID) {
    return request({
      url:'/recordsByUid/${userID}',
      method:'get',
      userID
    })
  }

  function addBill(record) {
    return request({
      url:'/',
      method:'post',
      record
    })
  }

  function deleteBill(recordID) {
    return request({
      url:'/${recordID}',
      method:'delete',
      recordID
    })
  }
}

