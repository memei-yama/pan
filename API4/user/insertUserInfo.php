<?php
        $user = 'root';
        $dbname = 'food_management';
        $passwd = 'group7';
        $host = 'localhost';
        $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";

        $pdo = new PDO($dsn, $user, $passwd);
        $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        //引数を変数に格納
        $user_name = $_GET["user_name"];
        $user_passwd = $_GET["user_passwd"];
        $user_address = $_GET["user_address"];
        $user_mail = $_GET["user_mail"];

        //SQL実行
        $sql = "insert into user (user_id, user_name, user_passwd, user_address, user_mail, family_id) select MAX(user_id) + 1, '". $user_name ."', '". $user_passwd ."$
        $stm = $pdo->prepare($sql);
        $stm->execute();

        //user_idの最大値を取得
        $sql = "select max(user_id) from user";
        $stm = $pdo->prepare($sql);
        $stm->execute();
        $result = $stm->fetch(PDO::FETCH_ASSOC);
        $maxId = $result['max(user_id)'];

        //json形式に変換
        $maxId_json = json_encode($maxId, JSON_UNESCAPED_UNICODE);
        return $maxId_json;

?>