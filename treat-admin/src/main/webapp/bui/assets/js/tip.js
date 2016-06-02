/**
 * @fileOverview �����õ���ʾ��Ϣ
 * @ignore
 */

define('bui/tooltip/tip',['bui/common','bui/overlay'],function (require) {
  var BUI = require('bui/common'),
    Overlay = require('bui/overlay'),
    CLS_ALIGN_PREFIX = 'x-align-',
    MAP_TYPES = {
      left : ['cl','cr'], //����
      right : ['cr','cl'], //����
      top : ['tc','bc'], //����
      bottom : ['bc','tc'], //����
      'top-left' : ['tl','bl'],
      'top-right' : ['tr','br'],
      'bottom-left' : ['bl','tl'],
      'bottom-right' : ['br','tr']
    };
  //��ȡ����
  function getOffset(type,offset){
    if(type === 'left'){
      return [-1 * offset,-4];
    }
    if(type === 'right'){
      return [offset,-4];
    }
    if(type.indexOf('top')){
      return [0,offset];
    }

    if(type.indexOf('bottom')){
      return [0,-1 * offset];
    }
  }

  var TipView = Overlay.OverlayView.extend({
    renderUI : function(){

    },
    //��ȡ��ʾ�ı�������
    _getTitleContainer : function(){
      return  this.get('el');
    },
    //�����ı�
    _uiSetTitle : function(title){
      var _self = this,
        titleTpl = _self.get('titleTpl'),
        container = _self._getTitleContainer(),
        titleEl = _self.get('titleEl'),
        tem;
      if(titleEl){
        titleEl.remove();
      }
      title = title || '';
      if(BUI.isString(title)){
        title = {title : title};
      }
      tem = BUI.substitute(titleTpl,title);
      titleEl = $(tem).appendTo(container);
      _self.set('titleEl',titleEl);
    },
    //���ö�����ʽ
    _uiSetAlignType : function(type,ev){
      var _self = this;
      if(ev && ev.prevVal){
        _self.get('el').removeClass(CLS_ALIGN_PREFIX + ev.prevVal);
      }
      if(type){
        _self.get('el').addClass(CLS_ALIGN_PREFIX + type);
      }
    }
  },{
    ATTRS : {
      title : {},
      titleEl : {},
      alignType : {}
    }
  },{
    xclass : 'tooltip-view'
  });
  
  /**
   * @class BUI.Tooltip.Tip
   * @extends BUI.Overlay.Overlay
   * ���׵���ʾ��Ϣ
   * 
   * ** ����Լ򵥵�ʹ�õ���tip **
   * <pre><code>
   * BUI.use('bui/tooltip',function (Tooltip) {
   *  //��ʹ��ģ��ģ������ʾ
   *   var t1 = new Tooltip.Tip({
   *     trigger : '#t1',
   *     alignType : 'left', //����
   *     showArrow : false, //����ʾ��ͷ
   *     offset : 5, //������ߵľ���
   *     title : '���κ���ʽ��<br>��ߵ���ʾ��Ϣ'
   *   });
   *   t1.render();
   *  });
   * </code></pre>
   *
   * ** Ҳ��������ģ�� **
   * <pre><code>
   * BUI.use('bui/tooltip',function (Tooltip) {
   *  //ʹ��ģ��ģ������ʾ
   *   var t1 = new Tooltip.Tip({
   *     trigger : '#t1',
   *     alignType : 'left', //����
   *     titleTpl : '&lt;span class="x-icon x-icon-small x-icon-success"&gt;&lt;i class="icon icon-white icon-question"&gt;&lt;/i&gt;&lt;/span&gt;\
   *     &lt;div class="tips-content"&gt;{title}&lt;/div&gt;',
   *     offset : 5, //������ߵľ���
   *     title : '���κ���ʽ��&lt;br&gt;��ߵ���ʾ��Ϣ'
   *   });
   *   t1.render();
   *  });
   * </code></pre>
   */
  var Tip = Overlay.Overlay.extend({
    //���ö��뷽ʽ
    _uiSetAlignType : function(type){
      var _self = this,
        offset = _self.get('offset'),
        align = _self.get('align') || {},
        points = MAP_TYPES[type];
      if(points){
        align.points = points;
        if(offset){
          align.offset = getOffset(type,offset);
        }
        _self.set('align',align);
      }
    }
  },{
    ATTRS : {
      //ʹ��ί�еķ�ʽ��ʾ��ʾ��Ϣ
      delegateTrigger : {
        value : true
      },
      /**
       * �������ͣ������� top,left,right,bottom���ֳ��÷�ʽ���������뷽ʽ������ʹ��@see{BUI.Tooltip.Tip#property-align}����
       * 
       * @type {String}
       */
      alignType : {
        view : true
      },
      /**
       * ��ʾ�����ݣ��ı����߼�ֵ��
       * <pre><code>
       *     var tip =  new Tip({
       *        title : {a : 'text a',b:'text b'}, //�����Ƕ���
       *        titleTpl : '<p>this is {a},because {b}</p>' // <p>this is text a,because text b</p>
       *      });
       * </code></pre>
       * @cfg {String|Object} title
       */
      /**
       * ��ʾ������
       * <pre><code>
       *  //�����ı�
       *  tip.set('title','new title');
       *
       *  //���ö���
       *  tip.set('title',{a : 'a',b : 'b'})
       * </code></pre>
       * @type {Object}
       */
      title : {
        view : true
      },
      /**
       * ��ʾ�����ͷ
       * @override
       * @default true
       * @cfg {Boolean} [showArrow = true]
       */
      showArrow : {
        value : true
      },
      /**
       * ��ͷ�����ڵ�λ�ã���һ��ѡ���������� .arrow-wraper
       * <pre><code>
       *     new Tip({ //�������������ؼ���ģ��
       *       arrowContainer : '.arrow-wraper',
       *       tpl : '<div class="arrow-wraper"></div>'
       *     });
       *     
       *     new Tip({ //Ҳ��������title��ģ��
       *       arrowContainer : '.arrow-wraper',
       *       titleTpl : '<div class="arrow-wraper">{title}</div>'
       *     });
       * </code></pre>   
       * @cfg {String} arrowContainer
       */
      arrowContainer : {
        view : true
      },
      //�Զ���ʾ
      autoHide : {
        value : true
      },
      //�����Զ���������
      autoHideType : {
        value : 'leave'
      },
      /**
      * ��ʾ��tip ���봥����Dom�ľ���
      * <pre><code>
      *  var tip =  new Tip({
      *    title : {a : 'text a',b:'text b'}, //�����Ƕ���
      *    offset : 10, //����
      *    titleTpl : '<p>this is {a},because {b}</p>' // <p>this is text a,because text b</p>
      *  });
      * </code></pre>
      * @cfg {Number} offset
      */
      offset : {
        value : 0
      },
      /**
       * ������ʾtip���¼����ƣ�Ĭ��Ϊmouseover
       * @type {String}
       * @protected
       */
      triggerEvent : {
        value : 'mouseover'
      },
      /**
       * ��ʾ�ı���ģ��
       * <pre><code>
       *  var tip =  new Tip({
       *    title : {a : 'text a',b:'text b'}, //�����Ƕ���
       *    offset : 10, //����
       *    titleTpl : '<p>this is {a},because {b}</p>' // <p>this is text a,because text b</p>
       *  });
       * </code></pre>
       * @type {String}
       */
      titleTpl : {
        view : true,
        value : '<span>{title}</span>'
      },
      xview : {
        value : TipView
      }
    }
  },{
    xclass : 'tooltip'
  });

  Tip.View = TipView;

  return Tip;
});