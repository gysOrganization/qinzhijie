Page({
  data: {
    bookDetailList: []
  },

  onLoad: function (event) {
    var that = this
    wx.request({
      url: 'https://127.0.0.1:8081/bookDetail/getList',
      method: 'POST',
      data: {
        currentPage: "1",
        pageSize: "9999",
        queryObj: {
          bookId: event.bookId
        }
      },
      success: function(res) {
        console.log(res)
        var searchData = res.data
        if (res.data.data !== null) {
          that.setData({
            bookDetailList: res.data.data.dataList
          })
        }

        var pages = getCurrentPages()
        var curPages = pages[pages.length - 1].route

        if ('pages/detailList/detailList' !== curPages) {
          wx.navigateTo({
            url: '../detailList/detailList'
          })
        }
      }
    })  
  },
  showPicList(e) {
    var bookDetailId = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '../picList/picList?bookDetailId=' + bookDetailId
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
    wx.navigateTo({
      url: '../bookDetail/bookDetail?partName=' + this.data.inputValue
    })
  }
})