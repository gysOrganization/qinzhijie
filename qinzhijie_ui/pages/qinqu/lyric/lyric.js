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
    wx.showLoading({
      title: '加载中...',
      mask: true
    });
    var that = this
    that.setData({
      inputValue: event.queryStr
    })
    wx.request({
      url: 'https://www.gysp.top/bookLyric/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "200",
        queryObj: {
          id: event.id
        }
      },
      success: function(res) {
        if (res.data.data !== null) {
          that.setData({
            lyricList: res.data.data.dataList
          })
        }
        wx.hideLoading();
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
    wx.showLoading({
      title: '加载中...',
      mask: true
    });
    var that = this
    wx.request({
      url: 'https://www.gysp.top/station/search',
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
        wx.hideLoading();
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