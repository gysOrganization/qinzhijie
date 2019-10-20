const app = getApp(),myAudio=require("audioManager.js");
var mockData={//模拟数据

  url:"http://www.gysp.top/qinzhijieMusic/test.mp3",
  name:'音频播放'
};

Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    TabCur: 0,
    MainCur: 0,
    VerticalNavTop: 0,
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
  onLoad: function () {
    this.loadData();
  },
  onShow(){
    myAudio.showAudio(this);//在显示时同步当前歌曲播放进度
  },
  loadData(){//模拟从服务器获取数据
  var t=this;
  wx.showLoading({
    title: 'loading...',
  })
    setTimeout(function(){
      wx.hideLoading();
      let backgroundAudio = t.data.backgroundAudio;
      backgroundAudio.name=mockData.name;
      backgroundAudio.url=mockData.url;
      backgroundAudio.image=mockData.image;
      t.setData({
        backgroundAudio
      });
      t.initBackGroundAudio(mockData);
    },2000);
  },
  initBackGroundAudio(e){
    let audio={//设置播放器属性，src与title为必填
      src:e.url,
      title:e.name,
      coverImgUrl:e.image
    };
    myAudio.init(audio, this);//初始化audio
    myAudio.getDuration(audio,this);//获取视频长度
    myAudio.pause();//暂停播放
    this.playAudio()//加载完毕就开始播放
  },
  playAudio(){//播放与暂停
    console.log(this.data.backgroundAudio.isPlaying);
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
