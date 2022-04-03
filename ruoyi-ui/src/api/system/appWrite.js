import request from '@/utils/request'

// 查询app记录列表
export function listAppWrite(query) {
  return request({
    url: '/system/appWrite/list',
    method: 'get',
    params: query
  })
}

// 查询app记录详细
export function getAppWrite(id) {
  return request({
    url: '/system/appWrite/' + id,
    method: 'get'
  })
}

// 新增app记录
export function addAppWrite(data) {
  return request({
    url: '/system/appWrite',
    method: 'post',
    data: data
  })
}

// 修改app记录
export function updateAppWrite(data) {
  return request({
    url: '/system/appWrite',
    method: 'put',
    data: data
  })
}

// 删除app记录
export function delAppWrite(id) {
  return request({
    url: '/system/appWrite/' + id,
    method: 'delete'
  })
}
