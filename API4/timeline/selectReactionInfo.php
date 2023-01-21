<?php
    //リアクションしたユーザを取得
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";


    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $timeline_id = $_GET["timeline_id"];

    $sql = "SELECT timeline.timeline_id, user.user_id, user.user_name, reaction.reaction_date from user join reaction on user.user_id = reaction.user_id join timeline on user.user_id = timeline.user_id where timeline.timeline_id = ".$timeline_id.";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($result, JSON_UNESCAPED_UNICODE);
?>





