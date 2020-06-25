//
//  BOJ_2588.swift
//  Algorithm
//
//  Created by Theodore's iMac on 2020/06/25.
//  Copyright © 2020 Sample. All rights reserved.
//

import Foundation

class BOJ_2588 {
    func solve() {
        let number = Int(readLine()!)!
        let number2 = readLine()!

        for index in (0...2).reversed() {
            print( number * Int(String(number2[number2.index(number2.startIndex, offsetBy: index)]))!)
        }

        print( number * Int(number2)!)
    }
}
