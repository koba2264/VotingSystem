var choiceElm = document.querySelectorAll(".choice");
var textElm = document.querySelector(".text");
var popupElm = document.querySelector(".popup");
var canBtnElm = document.querySelector(".cancel-button");
var okBtnElm = document.querySelector(".ok-button");
// ポップアップが表示されていればtrueにする
var popupFlag = false;
var select = null;

// フォームを送る関数
function postForm(value) {
    // formの作成
    var form = document.createElement("form");
    var request = document.createElement("input");

    form.method = 'POST';
    form.action = 'StandBy.action';

    request.type = 'hidden';
    request.name = 'choice';
    request.value = value;

    form.appendChild(request);
    document.body.appendChild(form);

    form.submit();
}

// ポップアップを消す関数
function popout() {
    if (popupFlag) {
        popupElm.style.zIndex = -1;
        canGrayout();
        popupFlag = false;
    }
}

// 全体を具レイアウトするための関数
function grayout() {
    for (const elm of choiceElm) {
        elm.classList.add('grayout');
    }
    textElm.classList.add('grayout');
};

// グレイアウトを解除するための関数
function canGrayout() {
    for (const elm of choiceElm) {
        elm.classList.remove('grayout');
    }
    textElm.classList.remove('grayout');
};

// 左右の選択肢でのイベント
for (const elm of choiceElm) {
    // マウスがホバーされてきたらハイライトする
    elm.addEventListener('mouseover', function() {
        if (!popupFlag) {
            elm.classList.add("highlight");
        };
    });
    // マウスが離れたらハイライトを解除
    elm.addEventListener('mouseleave', function() {
        if (!popupFlag) {
            elm.classList.remove("highlight");
        }
    });
    // クリックしたら全体がグレーアウトしてポップアップが出てくる
    elm.addEventListener('click', function() {
        if (elm.classList.contains('left')) {
            select = 'A';
        } else {
            select = 'B';
        }
        popupFlag = true;
        grayout();
        elm.classList.remove("highlight");
        popupElm.style.zIndex = 10;
    });
}

// キャンセルボタンが押されたらポップアップを解除する
canBtnElm.addEventListener('click', function() {
 popout();
})

// okボタンが押されたらフォームを送信する
okBtnElm.addEventListener('click', function() {
    // 選択せずにokを押したらポップアップが消えるだけ
    if (popupFlag & select != null) {
        console.log(select);
        postForm(select);
    } else {
        popout();
    }
})