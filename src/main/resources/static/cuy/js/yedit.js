/**
 * Created by young on 2018/8/2 0002.
 */
/**
 * 设置编辑器变更状态
 * @param $is_change
 */
function resetEditorChanged($is_change) {
    if ($is_change) {
        $(".cus-y-save").parent().removeClass("y-disabled").addClass("y-change");
    } else {
        $(".cus-y-save").parent().removeClass("y-change").addClass("y-disabled");
    }
}

var yEditor;
//编辑器
$(function () {
    yEditor = editormd("y-editormd", {//注意1：这里的就是上面的DIV的id属性值
        width: "100%",
        height: 800,
//                syncScrolling: "single",
        toolbarIcons: function () {
            // Or return editormd.toolbarModes[name]; // full, simple, mini
            // Using "||" set icons align right.
            return ["chevronleft", "|", "save", "|", "undo", "redo", "|",
                "bold", "del", "italic", "quote", "ucwords", "uppercase", "lowercase", "|",
                "h1", "h2", "h3", "h4", "h5", "h6", "|",
                "list-ul", "list-ol", "hr", "|",
                "link", "reference-link", "image", "code", "preformatted-text", "code-block", "table", "datetime", "emoji", "html-entities", "pagebreak", "|",
                "goto-line", "tasks", "paperclip", "tachometer", "||",
                "watch", "preview", "fullscreen", "clear", "search", "help"]
        },
        //自定义类
        toolbarIconsClass: {
            chevronleft: "fa-chevron-left",
            save: "fa-save cus-y-save",
            tasks: "fa-tasks",
            paperclip: "fa-paperclip",
            tachometer: "fa-tachometer"
        },
        //自定义title
        lang: {
            toolbar: {
                chevronleft: "返回",
                save: "保存",
                tasks: "DFM 任务列表",
                paperclip: "附件",
                tachometer: "模版"
            }
        },

        // 自定义工具栏按钮的事件处理
        toolbarHandlers: {
            tasks: function (cm, icon, cursor, selection) {
                cm.replaceSelection("- [x] ");
            },
            save: function (cm, icon, cursor, selection) {
                resetEditorChanged(false);
                alert("以保存");
            },

        },
        path: "/editormd/lib/",
        saveHTMLToTextarea: true,

        emoji: true,//emoji表情，默认关闭
        taskList: true,
        tocm: true, // Using [TOCM]
        tex: true,// 开启科学公式TeX语言支持，默认关闭

        flowChart: true,//开启流程图支持，默认关闭
        sequenceDiagram: true,//开启时序/序列图支持，默认关闭,

        dialogLockScreen: false,//设置弹出层对话框不锁屏，全局通用，默认为true
        dialogShowMask: false,//设置弹出层对话框显示透明遮罩层，全局通用，默认为true
        dialogDraggable: false,//设置弹出层对话框不可拖动，全局通用，默认为true
        dialogMaskOpacity: 0.4, //设置透明遮罩层的透明度，全局通用，默认值为0.1

        codeFold: true,

        imageUpload: true,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL: "/smart-api/upload/editormdPic/",

        /*上传图片成功后可以做一些自己的处理*/
        onload: function () {
            //console.log('onload', this);
            //this.fullscreen();
            //this.unwatch();
            //this.watch().fullscreen();
            //this.width("100%");
            //this.height(480);
            //this.resize("100%", 640);
        },
        onchange: function () {
            resetEditorChanged(true);
        }

    });

    //layui tips
    var tip_index = 0;
    $(document).on('mouseenter', '.editormd-menu li a', function () {
        var title = $(this).attr('title');
        if (title) {
            $(this).attr('data-title', title);
            $(this).removeAttr('title');
        } else {
            title = $(this).attr('data-title');
        }
        tip_index = layer.tips(title, $(this), {tips: 3, time: 0});
    }).on('mouseleave', '.editormd-menu li a', function () {
        layer.close(tip_index);
    });
})