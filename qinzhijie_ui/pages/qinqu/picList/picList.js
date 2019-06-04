const app = getApp()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    picList: []
  },
  onLoad: function(event) {
    var that = this
    wx.request({
      url: 'http://47.105.212.81:8081/bookDetail/getPicList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          id: event.bookDetailId
        }
      },
      success: function(res) {
        if (res.data.data !== null) {
          that.setData({
            picList: res.data.data.dataList[0].allPath.replace(/\\/g,"//").split(";")
          })
        }
      }
    })  
  },
  showPic(e){
    wx.navigateTo({
      url: '/pages/qinqu/pic/pic?url=' + e.currentTarget.dataset.str
    })
  }
})