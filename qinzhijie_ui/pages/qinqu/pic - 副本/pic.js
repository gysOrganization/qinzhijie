const app = getApp()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    url: ''
  },
  onLoad: function(event) {
    var that = this
    that.setData({
      url: event.url
    })
  }
})