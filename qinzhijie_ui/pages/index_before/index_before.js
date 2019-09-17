//获取应用实例
const app = getApp()

Page({
    data: {
        //判断小程序的API，回调，参数，组件等是否在当前版本可用。
        canIUse: wx.canIUse('button.open-type.getUserInfo'),
        isHide: true,
        openId: ""
    },

    bindGetUserInfo: function(e) {
        if (e.detail.userInfo) {
            //用户按了允许授权按钮
            var that = this;
            // 获取到用户的信息了，打印到控制台上看下
            console.log("用户的信息如下：");
            //uerinfo放到全局变量中
            getApp().globalData.userInfo = e.detail.userInfo
          console.log(e.detail.userInfo)
            //授权成功后,将登陆信息回写到后台

            // 发送 res.code 到后台换取 openId
            wx.login({
              success: res => {
                console.log(res.code);
                wx.request({
                  url: 'http://localhost:8081/login/getOpenId',
                  method: 'POST',
                  header: {
                    "Content-Type": "application/x-www-form-urlencoded"
                  },
                  data: {
                    jsCode: res.code
                  },
                  success: function (res) {
                    //如果获得openid 就调用接口，向后台调用登陆接口
                    //通过接口向后台写如数据
                    wx.request({
                      url: 'http://localhost:8081/login/loginIn',
                      method: 'POST',
                      header: {
                        "Content-Type": "application/x-www-form-urlencoded"
                      },
                      data: {
                        openId: res.data.data.openid
                      },
                      success: function (res) {
                        if (res.data.message == 'success') {
                          //跳转到首页
                          wx.navigateTo({
                            url: '/pages/index/index'
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
            //用户按了拒绝按钮
            wx.showModal({
                title: '警告',
                content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
                showCancel: false,
                confirmText: '返回授权',
                success: function(res) {
                    // 用户没有授权成功，不需要改变 isHide 的值
                    if (res.confirm) {
                        console.log('用户点击了“返回授权”');
                    }
                }
            });
        }
    }
})
