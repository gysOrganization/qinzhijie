const app = getApp();
Component({
  options: {
    addGlobalClass: true,
  },
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    list: [
      {
        title: '历代琴谱',
        img: 'https://image.weilanwl.com/color2.0/plugin/qpczdh2307.jpg',
        url: '/verticalnav/verticalnav'
      },
      {
        title: '琴曲',
        img: 'https://image.weilanwl.com/color2.0/plugin/sylb2244.jpg',
        url: '/indexes/indexes'
      },
      {
        title: '琴声',
        img: 'https://image.weilanwl.com/color2.0/plugin/wdh2236.jpg',
        url: '/animation/animation'
      }
    ]
  },
  methods: {
    toChild(e) {
      wx.navigateTo({
        url: '/pages/qinqu' + e.currentTarget.dataset.url
      })
    },
  }
});