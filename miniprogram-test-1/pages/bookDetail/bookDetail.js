Page({
  data: {
    bookDetailList: [],
    bookId: ''
  },
  onLoad: function(event) {
    var that = this
    wx.request({
      url: 'https://127.0.0.1:8081/bookDetail/getListSpec',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          partName: event.partName,
          bookName: event.partName
        }
      },
      success: function (res) {
        var searchData = res.data
        if (res.data.data !== null) {
          that.setData({
            bookDetailList: res.data.data.dataList
          })
        }

        var pages = getCurrentPages()
        var curPages = pages[pages.length - 1].route

        if ('pages/bookDetail/bookDetail' !== curPages) {
          wx.navigateTo({
            url: '../bookDetail/bookDetail'
          })
        }
      }
    }) 
  },

  //搜索框文本内容显示
  inputBind: function(event) {
    this.setData({
      inputValue: event.detail.value
    })

  },
  query: function(event) {
    console.log(this.data.inputValue)
    var that = this
    wx.request({
      url: 'https://127.0.0.1:8081/bookDetail/getListSpec',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          partName: this.data.inputValue
        }
      },
      success: function(res) {
        var searchData = res.data
        if (res.data.data !== null) {
          that.setData({
            bookDetailList: res.data.data.dataList
          })
        }

        var pages = getCurrentPages()
        var curPages = pages[pages.length - 1].route

        if ('pages/bookDetail/bookDetail' !== curPages) {
          wx.navigateTo({
            url: '../bookDetail/bookDetail'
          })
        }
      }
    })  
  },

  showBookDetail(e) {
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '../detailList/detailList?bookId=' + id
    })
  },
  showPicList(e) {
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/picList/picList?bookDetailId=' + id
    })
  }
})