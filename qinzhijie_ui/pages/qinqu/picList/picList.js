const app = getApp()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    picList: [],
    bookDetailId: ''
  },
  onLoad: function(event) {
    var that = this
    wx.request({
      url: 'https://www.gysp.top/bookDetail/getPicList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          id: event.bookDetailId
        }
      },
      success: function (res) {
        if (res.data.data !== null) {
          that.setData({
            picList: res.data.data.dataList[0].allPath.replace(/\\/g,"//").split(";"),
            bookDetailId: event.bookDetailId
          })
        }
      }
    })  
  },
  showPic(e){
    var num = e.currentTarget.dataset.index
    wx.navigateTo({
      url: '/pages/qinqu/pic/pic?current=' + num + '&bookDetailId=' + this.data.bookDetailId
    })
  }
})