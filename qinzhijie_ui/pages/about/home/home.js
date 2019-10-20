//获取应用实例
const app = getApp()

Component({
  options: {
    addGlobalClass: true,
  },
  data: {
    starCount: 0,
    forksCount: 0,
    visitTotal: 0,
    userInfo: {},
    isloginIn:0
  },
  attached() {
    this.checkUserInfo();
    let that = this;
    if (app.globalData.userInfo != undefined){
      that.setData({
        userInfo: app.globalData.userInfo,
        isloginIn:1
      })
    }

    wx.showLoading({
      title: '数据加载中...',
      mask: true,
    })
    let i = 0;
    numDH();
    function numDH() {
      if (i < 20) {
        setTimeout(function () {
          that.setData({
            starCount: i,
            forksCount: i,
            visitTotal: i
          })
          i++
          numDH();
        }, 20)
      } else {
        that.setData({
          starCount: that.coutNum(3000),
          forksCount: that.coutNum(484),
          visitTotal: that.coutNum(24000)
        })
      }
    }
    wx.hideLoading()
  },
  methods: {
    coutNum(e) {
      if (e > 1000 && e < 10000) {
        e = (e / 1000).toFixed(1) + 'k'
      }
      if (e > 10000) {
        e = (e / 10000).toFixed(1) + 'W'
      }
      return e
    },
    loginIn(){
      wx.showLoading({
        title: '数据加载中...',
        mask: true,
      })
      wx.getSetting({
      success: res => {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          if (!res.authSetting['scope.userInfo']){
            wx.navigateTo({
              url: '/pages/index_before/index_before'
            })
          }
      }
    })
    },
    checkUserInfo(){
      wx.showLoading({
        title: '数据加载中...',
        mask: true,
      })
      wx.getSetting({
        success: res => {
          //查看userinfo的全局变量是否为空，如果为空且已经授权，就再去取一次userinfo
          if (getApp().globalData.userInfo == undefined && res.authSetting['scope.userInfo']) {
            wx.getUserInfo({
              success: res => {
                getApp().globalData.userInfo = res.userInfo
              }
            })
            wx.navigateTo({
              url: '/pages/index/index?pageCur=about'
            })
          }
        }
      })
      wx.hideLoading();
    }
  }
})