//获取应用实例
const app = getApp()

Page({
  data: {
    isHide: false,
    openId: "",
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    bookList: [],
    load: true
  },

  bindGetUserInfo: function(e) {
    wx.showLoading({
      title: '数据加载中...',
      mask: true,
    })
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      var that = this;
      //uerinfo放到全局变量中
      getApp().globalData.userInfo = e.detail.userInfo
      //授权成功后,将登陆信息回写到后台

      // 发送 res.code 到后台换取 openId
      wx.login({
        success: res => {
          wx.showLoading({
            title: '数据加载中...',
            mask: true,
          })
          wx.request({
            url: 'https://www.gysp.top/login/getOpenId',
            method: 'POST',
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            data: {
              jsCode: res.code
            },
            success: function(res) {
              //如果获得openid 就调用接口，向后台调用登陆接口
              //通过接口向后台写如数据
              wx.request({
                url: 'https://www.gysp.top/login/loginIn',
                method: 'POST',
                header: {
                  "Content-Type": "application/x-www-form-urlencoded"
                },
                data: {
                  openId: res.data.data.openid
                },
                success: function(res) {
                  if (res.data.message == 'success') {
                    //跳转到登录页面
                    wx.navigateTo({
                      url: '/pages/index/index?pageCur=about'
                    })
                  }
                }
              })
            }
          })
        }
      })
      that.setData({
        isHide: false
      });
    } else {
      //跳转到登录页面
      wx.navigateTo({
        url: '/pages/index/index?pageCur=about'
      })
    }
  }
})