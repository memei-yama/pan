<?php
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";


    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $family_id = $_GET["family_id"];
    $recUser_id = $_GET["recUser_id"];
    $sendUser_id = $_GET["sendUser_id"];

    $sql = "insert into friend (group_id, friend_id1, friend_id2, family_id) select max(group_id) + 1, ". $sendUser_id .", ". $recUser_id .", ". $family_id ." from fri$
    $stm = $pdo->prepare($sql);
    $stm->execute();

    $sql = "insert into friend (group_id, friend_id1, friend_id2, family_id) select max(group_id) + 1, ". $recUser_id .", ". $sendUser_id .", ". $family_id ." from fri$
    $stm = $pdo->prepare($sql);
    $stm->execute();

    /*$sql = "select * from friend where friend_id1 = ". $sendUser_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($result, JSON_UNESCAPED_UNICODE);*/
?>