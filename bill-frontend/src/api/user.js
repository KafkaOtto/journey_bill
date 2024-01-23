import request from '@/utils/request'

export function userLogin(data) {
  return request({
    url: '/auth/login',
    method: 'post',
    data
  })
}

// 目前我传的是userID,但是前端没有user ID，可能要改成email
export function getBills(userID) {
  return request({
    url:'/recordsByUid/${userID}',
    method:'get',
    params: {
      userID
    }
  })
}

// record包含了三个string： date，location，cost，其他属性（recordID）后端生成
export function addBill(record) {
  return request({
    url:'/',
    method:'post',
    params: {
      record
    }
  })
}

// 传入recordID
export function deleteBill(recordID) {
  return request({
    url:'/${recordID}',
    method:'delete',
    params: {
      recordID
    }
  })
}

