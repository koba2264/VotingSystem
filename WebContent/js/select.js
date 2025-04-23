class ChoiceMove {
    init() {
        this.choiceElm = document.querySelectorAll(".choice");
        this.textElm = document.querySelector(".text");
        this.popupElm = document.querySelector(".popup");
        const canBtnElm = document.querySelector(".cancel-button");
        const okBtnElm = document.querySelector(".ok-button");
        // ポップアップが表示されていればtrueにする
        this.popupFlag = false;
        let select = null;

        // 左右の選択肢でのイベント
        for (const elm of this.choiceElm) {
            // マウスがホバーされてきたらハイライトする
            elm.addEventListener('mouseover', () => {
                if (!this.popupFlag) {
                    elm.classList.add("highlight");
                };
            });
            // マウスが離れたらハイライトを解除
            elm.addEventListener('mouseleave', () => {
                if (!this.popupFlag) {
                    elm.classList.remove("highlight");
                }
            });
            // クリックしたら全体がグレーアウトしてポップアップが出てくる
            elm.addEventListener('click', () => {
                if (elm.classList.contains('left')) {
                    select = 'A';
                } else {
                    select = 'B';
                }
                this.popupFlag = true;
                this.popup(elm);
            });
        }

        // キャンセルボタンが押されたらポップアップを解除する
        canBtnElm.addEventListener('click', () => {
            this.popout();
        })

        // okボタンが押されたらフォームを送信する
        okBtnElm.addEventListener('click', () => {
            // 選択せずにokを押したらポップアップが消えるだけ
            if (this.popupFlag & select != null) {
                this.postForm(select);
            } else {
                this.popout();
            }
        })

    };

    // フォームを送る関数
    postForm(value) {
        // formの作成
        const form = document.createElement("form");
        const request = document.createElement("input");

        form.method = 'POST';
        form.action = 'StandBy.action';

        request.type = 'hidden';
        request.name = 'choice';
        request.value = value;

        form.appendChild(request);
        document.body.appendChild(form);

        form.submit();
    };

    popup(elm) {
        elm.classList.remove("highlight");
        this.grayout();
        this.popupElm.style.zIndex = 10;
    }

    // ポップアップを消す関数
    popout() {
        if (this.popupFlag) {
            this.popupElm.style.zIndex = -1;
            this.canGrayout();
        }
    }

    // 全体を具レイアウトするための関数
    grayout() {
        for (const elm of this.choiceElm) {
            elm.classList.add('grayout');
        }
        this.textElm.classList.add('grayout');
    };

    // グレイアウトを解除するための関数
    canGrayout() {
        for (const elm of this.choiceElm) {
            elm.classList.remove('grayout');
        }
        this.textElm.classList.remove('grayout');
    };

}

const choiceMove = new ChoiceMove();
choiceMove.init();