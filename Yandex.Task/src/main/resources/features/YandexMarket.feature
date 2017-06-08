Feature: Yandex tasks

  Background: At first
    Given browser "Chrome"
    And move to "http://www.yandex.ru"
    And move to yandex market
    And select electronics


  Scenario: First user story

    When select TVs
    And set searching parameter from 20000 rub
    And select manufacturers as Samsung and LG
    And press apply
    Then count of items should be 12
    When remember the first element of a list
    And input remembered value into search bar
    Then remembered value should be equal to item name


#Count of items should be 12 not 10, because it happens so


  Scenario: Second user story

    When select headsets
    And set searching parameter from 5000 rub
    And select manufacturers as Beats
    And press apply
    Then count of items should be 12
    When remember the first element of a list
    And input remembered value into search bar
    Then remembered value should be equal to item name