const app = getApp();
Component({
  options: {
    addGlobalClass: true,
  },
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    liDaiQinPuStatus:0,//默认置灰
    qinquStatus: 0,//默认置灰
    qinshengStatus: 0,//默认置灰
    inputValue:'',
    list: [
      {
        title: '历代琴谱',
        img: 'https://image.weilanwl.com/color2.0/plugin/qpczdh2307.jpg',
        url: '/verticalnav/verticalnav'
      },
      {
        title: '琴曲',
        img: 'https://image.weilanwl.com/color2.0/plugin/sylb2244.jpg',
        url: '/lyric/lyric'
      }
      // ,
      // {
      //   title: '琴声',
      //   img: 'https://image.weilanwl.com/color2.0/plugin/wdh2236.jpg',
      //   url: '/animation/animation'
      // },
      // {
      //   title: '指法',
      //   img: 'https://image.weilanwl.com/color2.0/plugin/wdh2236.jpg',
      //   url: '/animation/animation'
      // }
    ]
  },
  methods: {
    toChild(e) {
      wx.navigateTo({
        url: '/pages/qinqu' + e.currentTarget.dataset.url
      })
    },
    tabSelect(e) {
      this.setData({
        TabCur: e.currentTarget.dataset.id,
        scrollLeft: (e.currentTarget.dataset.id - 1) * 60
      })

      var childUrl = ""
      if (e.currentTarget.dataset.id == 1){
        childUrl = "/verticalnav/verticalnav"
      } else if (e.currentTarget.dataset.id == 2){
        childUrl = "/lyric/lyric"
      } else if (e.currentTarget.dataset.id == 3){
        childUrl = ""
      }

      wx.navigateTo({
        url: '/pages/qinqu' + childUrl + '?queryStr=' + this.data.inputValue
      })
    },
    inputBind: function (event) {
      this.setData({
        inputValue: event.detail.value
      })
    },
    query(e){
      var that = this
      if (this.data.inputValue != null && this.data.inputValue != undefined && this.data.inputValue != ''){
            wx.request({
              url: 'http://localhost:8081/station/searchStatus',
              method: 'POST',
              header: {
                "Content-Type": "application/x-www-form-urlencoded"
              },
              data: {
                queryStr: this.data.inputValue
              },
            success: function (res) {
              if (res.data.data !== null) {
                that.setData({
                  liDaiQinPuStatus: res.data.data.liDaiQinPuStatus,
                  qinquStatus: res.data.data.qinquStatus,
                  qinshengStatus: res.data.data.qinshengStatus
                })
              }
            }
          })
      }
    }
  }
});