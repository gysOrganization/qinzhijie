const app = getApp()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    bookDetailList: [],
    queryList: []
  },

  onLoad: function (event) {
    wx.showLoading({
      title: '加载中...',
      mask: true
    });
    var that = this
    wx.request({
      url: 'https://www.gysp.top/bookDetail/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          bookId: event.bookId
        }
      },
      success: function(res) {
        if (res.data.data !== null) {
          that.setData({
            bookDetailList: res.data.data.dataList,
            queryList: []
          })
        }
        wx.hideLoading();
      }
    })  
  },
  showPicList(e) {
    var bookDetailId = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/qinqu/picList/picList?bookDetailId=' + bookDetailId
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
      url: 'https://www.gysp.top/bookDetail/getListSpec',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          partName: this.data.inputValue,
          bookName: this.data.inputValue
        }
      },
      success: function (res) {

        if (res.data.data !== null) {
          that.setData({
            bookDetailList: [],
            queryList: res.data.data.dataList
          })
        }else {
          that.setData({
            bookDetailList: [],
            queryList: []
          })
        }
        wx.hideLoading();
      }
    }) 
  },
  showBookDetail(e) {
    wx.showLoading({
      title: '加载中...',
      mask: true
    });
    var id = e.currentTarget.dataset.id
    var that = this
    wx.request({
      url: 'https://www.gysp.top/bookDetail/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          bookId: id
        }
      },
      success: function (res) {
        if (res.data.data !== null) {
          that.setData({
            bookDetailList: res.data.data.dataList,
            queryList: []
          })
        }
        wx.hideLoading();
      }
    })  
  },
  showPicList(e) {
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/qinqu/picList/picList?bookDetailId=' + id
    })
  }
})