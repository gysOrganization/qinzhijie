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
  onLoad() {
    wx.showLoading({
      title: '加载中...',
      mask: true
    });
    var that = this;
    wx.request({
      url: 'https://47.105.212.81:443/book/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
        }
      },
      success: function (res) {
        if (res.data.data !== null) {
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
      url: 'https://47.105.212.81:443/station/search',
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        queryStr: this.data.inputValue
      },
      success: function (res) {
        var searchData = res.data
        console.log(res.data.data.dataList)
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
    wx.navigateTo({
      url: '/pages/qinqu/detailList/detailList?bookId=' + id
    })
  }
})