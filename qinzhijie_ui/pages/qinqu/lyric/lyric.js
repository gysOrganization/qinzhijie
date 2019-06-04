const app = getApp()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    lyricList: []
  },

  onLoad: function (event) {
    var that = this
    wx.request({
      url: 'https://localhost:8081/bookLyric/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "200",
        queryObj: {
          
        }
      },
      success: function(res) {
        if (res.data.data !== null) {
          that.setData({
            lyricList: res.data.data.dataList
          })
        }
      }
    })  
  },
  //搜索框文本内容显示
  inputBind: function (event) {
    this.setData({
      inputValue: event.detail.value
    })
  },
  query: function (event) {
    var that = this
    wx.request({
      url: 'https://localhost:8081/station/search',
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        queryStr: this.data.inputValue
      },
      success: function (res) {
        var searchData = res.data
        if (res.data.data !== null) {
          that.setData({
            lyricList: res.data.data.lyricList
          })
        }
      }
    })
  },
  showLyricDetail(e) {
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/qinqu/lyricDetail/lyricDetail?lyricId=' + id
    })
  }
})