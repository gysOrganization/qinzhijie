const app = getApp()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    musicList: []
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
      url: 'https://www.gysp.top/music/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "300",
        queryObj: {
          name: event.queryStr
        }
      },
      success: function (res) {
        if (res.data.data !== null) {
          that.setData({
            musicList: res.data.data.dataList
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
      url: 'https://www.gysp.top/music/getList',
      method: 'POST',
      header: {
      },
      data: {
        currentPage: "1",
        pageSize: "300",
        queryObj: {
          name: this.data.inputValue
        }
      },
      success: function (res) {
        var searchData = res.data
        if (res.data.data !== null) {
          that.setData({
            musicList: res.data.data.dataList
          })
        }
        wx.hideLoading();
      }
    })
  },
  showLyricDetail(e) {
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/qinqu/music/music?id=' + id
    })
  }
})