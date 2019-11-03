const app = getApp(),myAudio=require("audioManager.js");
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
    music:{},
    music_on: true, //音乐是不是在播放
    audio:{
      image:'',
      url:'',
      name:''
    },
    backgroundAudio:{
      image:"",
      url:"",
      name:"",
      duration:"",
      durationTime: "",
      currentDuration:"",
      currentDurationTime:"",
      progress: "",
      isPlaying:false
    },
  },
  onLoad: function (event) {
    this.loadData(event);
  },
  onShow(){
    myAudio.showAudio(this);//在显示时同步当前歌曲播放进度
    while (false) {
      setTimeout(function () {
        if (resetAudio) {
          this.setData({
            music_on: false
          })
        }
      }, 3000);
    }
  },
  loadData(event){//模拟从服务器获取数据
  var t=this;
  wx.showLoading({
    title: 'loading...',
  })
    wx.request({
      url: 'https://www.gysp.top/music/getListById',
      method: 'POST',
      header: {
      },
      data: {
        currentPage: "1",
        pageSize: "300",
        queryObj: {
          id: event.id
        }
      },
      success: function (res) {
        var music = res.data.data.dataList[0];
        //设置图片是否旋转
        t.setData({
          music: res.data.data.dataList[0]
        })
        setTimeout(function () {
          wx.hideLoading();
          let backgroundAudio = t.data.backgroundAudio;
          backgroundAudio.name = music.name;
          backgroundAudio.url = "http://www.music.gysp.top/" +  music.mp3Url;
          backgroundAudio.image = music.image;
          t.setData({
            backgroundAudio
          });
          t.initBackGroundAudio(backgroundAudio);
        }, 2000);
        wx.hideLoading();
      }
    })
  },
  initBackGroundAudio(e){
    let audio={//设置播放器属性，src与title为必填
      src:e.url,
      title:e.name,
    };
    myAudio.init(audio, this);//初始化audio
    myAudio.getDuration(audio,this);//获取视频长度
    myAudio.pause();//暂停播放
    this.playAudio()//加载完毕就开始播放
  },
  playAudio(){//播放与暂停
    if (this.data.backgroundAudio.isPlaying){
      myAudio.pause(this);
    }else{
      myAudio.play(this);
    }
    //设置图片是否旋转
    this.setData({
      music_on: this.data.backgroundAudio.isPlaying
    })
  },
  dragAudioSlider(e){//拖动进度条
    myAudio.seek({
      progress:e.detail.value
    },this)//跳转到该进度
    myAudio.play(this);//播放
  },
  onUnload(){
    myAudio.uninstall(this);//卸载播放器，重置播放器数据
  }
})
