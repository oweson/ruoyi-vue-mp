import request from '@/utils/request'

// 查询云存储配置列表
export function listOssConfig(query) {
  return request({
    url: '/system/oss/config/list',
    method: 'get',
    params: query
  })
}

// 查询云存储配置详细
export function getOssConfig(ossConfigId) {
  return request({
    url: '/system/oss/config/' + ossConfigId,
    method: 'get'
  })
}

// 新增云存储配置
export function addOssConfig(data) {
  return request({
    url: '/system/oss/config',
    method: 'post',
    data: data
  })
}

// 修改云存储配置
export function updateOssConfig(data) {
  return request({
    url: '/system/oss/config',
    method: 'put',
    data: data
  })
}

// 删除云存储配置
export function delOssConfig(ossConfigId) {
  return request({
    url: '/system/oss/config/' + ossConfigId,
    method: 'delete'
  })
}

// 用户状态修改
export function changeOssConfigStatus(ossConfigId, status, configKey) {
  const data = {
    ossConfigId,
    status,
    configKey
  }
  return request({
    url: '/system/oss/config/changeStatus',
    method: 'put',
    data: data
  })
}
