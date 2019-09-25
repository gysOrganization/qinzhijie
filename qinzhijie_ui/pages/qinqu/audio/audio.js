const app = getApp()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    bookList: [],
    load: true
  },
  onLoad(event) {
    wx.showLoading({
      title: '加载中...',
      mask: true
    });
    var that = this;
    that.setData({
      inputValue: event.queryStr
    })
    wx.request({
      url: 'https://www.gysp.top/book/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          bookName: event.queryStr
        }
      },
      success: function (res) {
        if (res.data.data) {
          that.setData({
            bookList: res.data.data.dataList
          })
        }
      }
    });
  },
  onReady() {
    wx.hideLoading()
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
            bookList: res.data.data.bookList
          })
        }
      }
    })
    wx.hideLoading()
  },
  showBookDetail(e) {
    var id = e.currentTarget.dataset.id
    const backgroundAudioManager = wx.getBackgroundAudioManager()

    // backgroundAudioManager.title = '此时此刻'
    // backgroundAudioManager.epname = '此时此刻'
    // backgroundAudioManager.singer = '汪峰'
    // backgroundAudioManager.coverImgUrl = 'http://y.gtimg.cn/music/photo_new/T002R300x300M000003rsKF44GyaSk.jpg?max_age=2592000'
    // backgroundAudioManager.src = 'http://localhost:8081/mp3/test.mp3'
  }
})