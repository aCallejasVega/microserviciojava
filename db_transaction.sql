/*
 Navicat Premium Data Transfer

 Source Server         : db_transaction
 Source Server Type    : MongoDB
 Source Server Version : 50002
 Source Host           : localhost:27019
 Source Schema         : db_transaction

 Target Server Type    : MongoDB
 Target Server Version : 50002
 File Encoding         : 65001

 Date: 26/09/2021 00:27:42
*/


// ----------------------------
// Collection structure for transaction
// ----------------------------
db.getCollection("transaction").drop();
db.createCollection("transaction");

// ----------------------------
// Documents of transaction
// ----------------------------
db.getCollection("transaction").insert([ {
    _id: ObjectId("614fee7509b8a162c05a69d5"),
    idInvoice: NumberLong("1"),
    amount: "5000.00",
    date: ISODate("2021-09-25T22:31:55.000Z"),
    _class: "bo.com.apptransaction.entities.TransactionCollection"
} ]);
db.getCollection("transaction").insert([ {
    _id: ObjectId("614ff24f113a6238421ec18c"),
    idInvoice: NumberLong("7"),
    amount: "15000.00",
    date: ISODate("2021-09-25T22:31:55.000Z"),
    _class: "bo.com.apptransaction.entities.TransactionCollection"
} ]);
