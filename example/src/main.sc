theme: /
    @BlockEvents
        {
          "global" : true,
          "boundsTo" : "",
          "title" : "События",
          "actions" : [ {
            "buttons" : [ ],
            "type" : "buttons"
          } ]
        }
    state: newNode_14
        state: 1
            event!: noMatch
            go!: /newNode_2
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_14",
                name: "newNode_14 buttons",
                handler: function($context) {
                }
            });

    state: newNode_2 || label = Шаг 3
        a: Добрый день! Чем могу помочь?
        buttons:
            {text: "Пополнение Steam", force_reply: true} -> /newNode_3
            {text: "Покупка UC", force_reply: true} -> /newNode_7
            "Другой сервис или игра" -> /newNode_15

    state: newNode_3
        a: Какая у вас возникла проблема?
        buttons:
            {text: "Не пришли средства на Steam", force_reply: true} -> /newNode_4
            {text: "Не могу пополнить", force_reply: true} -> /newNode_5
            "Другое" -> /newNode_6
            {text: "Проблема не со Steam", force_reply: true} -> /newNode_2

    state: newNode_7
        a: Мне не пришли UC
        buttons:
            "Я пополнял по ID " -> /newNode_16
            {text: "Я покупал код (указывал только почту)", force_reply: true} -> /newNode_10
            {text: "Вопрос до покупки UC", force_reply: true} -> /newNode_6
            {text: "Главное меню", force_reply: true} -> /newNode_2

    state: newNode_4
        a: Пришлите ваш логин Steam и скриншот из приложения банка об оплате. Оператор сразу займётся вашим вопросом.
        buttons:
            {text: "Всё подготовил, переводите на оператора!", force_reply: true} -> /newNode_6

    state: newNode_5
        a:  Проверьте ваш логин Steam. \n
            Если вы находитесь в Крыму/Донецке/Луганске ознакомьтесь с гайдом.
            https://battlepass.ru/info/faq#krim
        buttons:
            {text: "Не помогает, соедините с оператором.", force_reply: true} -> /newNode_6

    state: newNode_10
        a: Выберите вашу проблему из списка и мы вам обязательно поможем!
        buttons:
            {text: "Я ввёл неправильную почту", force_reply: true} -> /newNode_17
            {text: "Код не пришёл", force_reply: true} -> /newNode_17
            {text: "Я не знаю, где вводить код", force_reply: true} -> /newNode_13
            {text: "Куда код приходит?", force_reply: true} -> /newNode_13

    state: newNode_16
        InputNumber:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Дайте ID, который вы вводили на сайте, оператор проверит всю информацию
            varName = number
            failureMessage = ["Введите число от 1 до 5"]
            then = /newNode_6
            minValue = 1
            maxValue = 99999999999

    state: newNode_17
        InputText:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Напишите почту, которую вы указывали при покупке, и я переведу вас на оператора!
            varName = text
            then = /newNode_6

    state: newNode_13
        a:  Код приходит на вашу почту! Подробная инструкция по активации кода здесь \n
            https://battlepass.ru/info/faq/pubg_mobile\n
            Спасибо, что пользуетесь нашим сервисом и хорошего дня!
        buttons:
            "Главное меню" -> /newNode_2

    state: newNode_6
        TransferToOperator:
            sendHistory = false
            openChatButton = Чат с оператором
            errorState = 
            messageToOperator = Здравствуйте! Мне нужна консультация
            messageToUser = Спасибо, за информацию! Перевожу на оператора
            chatClosedOperatorState = 
            noOperatorOnline = true
            noOperatorState = 

    state: newNode_15
        TransferToOperator:
            sendHistory = false
            openChatButton = Чат с оператором
            errorState = 
            messageToOperator = Здравствуйте! Мне нужна консультация
            messageToUser = Перевожу диалог на оператора
            chatClosedOperatorState = 
            noOperatorOnline = true
            noOperatorState =