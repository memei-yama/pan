<?php
    //投稿に対して反応したら呼び出される。いいねした日とそのユーザのIDを登録
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";


    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $timeline_id = $_GET["timeline_id"];
    $user_id = $_GET["user_id"];
    $reaction_date = date('Y-m-d');
    echo "a";

    $sql = "insert into reaction (timeline_id, user_id, reaction_date, reaction_id) select ". $timeline_id .", ". $user_id .", '". $reaction_date."', MAX(reaction_id) from reaction";
    $stm = $pdo->prepare($sql);
    $stm->execute();
        echo "b";
    /*$sql = "select timeline_id, user_id from reaction where reaction_id = max(reaction_id)";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($result, JSON_PRETTY_PRINT);*/
?>