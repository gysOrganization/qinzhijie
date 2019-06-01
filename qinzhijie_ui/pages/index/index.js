Page({
  data: {
    PageCur: 'basics'
  },
  NavChange(e) {
    this.setData({
      PageCur: e.currentTarget.dataset.cur
    })
  },
  onShareAppMessage() {
    return {
      title: '琴之界',
      imageUrl: '/images/share.jpg',
      path: '/pages/index/index'
    }
  },
})