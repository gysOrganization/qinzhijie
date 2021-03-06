Page({
  data: {
    PageCur: 'basics',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  NavChange(e) {
    this.setData({
      PageCur: e.currentTarget.dataset.cur
    })
  }, 
  onLoad: function (event) {
    var that = this
    if (event.pageCur != undefined){
      that.setData({
        PageCur: event.pageCur
      })
    }
  },
  onShareAppMessage() {
    return {
      title: '琴之界',
      imageUrl: '/images/share.jpg',
      path: '/pages/index/index'
    }
  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }

})