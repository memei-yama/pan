<?php
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";

    //データベース接続
    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $user_id = $_GET["user_id"];
    $family_name = $_GET["family_name"];

    //SQL実行
    if ($family_name == null) {
        $sql = "insert into family (family_id, family_name) select max(family_id) + 1, '家族' from family";
        $stm = $pdo->prepare($sql);
        $stm->execute();
    } else {
        $sql = "insert into family (family_id, family_name) select max(family_id) + 1, '". $family_name ."' from family";
        $stm = $pdo->prepare($sql);
        $stm->execute();
    }

    //family_idをjson形式に変換して返す
    $sql = "select max(family_id) from family";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetch(PDO::FETCH_ASSOC);
    $maxId = $result['max(family_id)'];
    $sql = "update user set family_id = ". $maxId ." where user_id = ". $user_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $arr = ["family_id" => $maxId , "family_name" => "$family_name" ];
    return json_encode($arr, JSON_UNESCAPED_UNICODE);
?>