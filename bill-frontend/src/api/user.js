import request from '@/utils/request'

export function userLogin(data) {
  return request({
    url: '/auth/login',
    method: 'post',
    data
  })
}

// 目前我传的是userID,但是前端没有user ID，可能要改成email
export function recordsByUid(userID) {
  return request({
    url:'/record/recordsByUid/'+userID.toString(),
    method:'get',
    userID
  })
}

// 目前我传的是userID,但是前端没有user ID，可能要改成email
export function recordsByRid(recordID) {
  return request({
    url:'/record/findByRecordId/'+recordID.toString(),
    method:'get',
    recordID
  })
}

// record包含了三个string： date，location，cost，其他属性（recordID）后端生成
export function addBill(data) {
  return request({
    url:'/record/',
    method:'post',
    data
  })
}

export function deleteBill(recordID) {
  return request({
    url:'/record/'+recordID,
    method:'delete',
    params: {
      recordID
    }
  })
}

