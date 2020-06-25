//
//  BOJ_10950.swift
//  Algorithm
//
//  Created by Theodore's iMac on 2020/06/25.
//  Copyright © 2020 Sample. All rights reserved.
//

import Foundation

class BOJ_10950 {
    func solve() {
        let N = Int(readLine()!)!

        for index in 1...N {
            let array = readLine()!.components(separatedBy: " ")
            print("Case #\(index): \(array[0]) + \(array[1]) = \(Int(array[0])!+Int(array[1])!)")
        }
    }
}
