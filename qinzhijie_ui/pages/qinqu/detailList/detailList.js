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
    var that = this
    wx.request({
      url: 'https://47.105.212.81:443/bookDetail/getList',
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
    var that = this
    wx.request({
      url: 'https://47.105.212.81:443/bookDetail/getListSpec',
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
      }
    }) 
  },
  showBookDetail(e) {
    var id = e.currentTarget.dataset.id
    var that = this
    wx.request({
      url: 'https://47.105.212.81:443/bookDetail/getList',
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