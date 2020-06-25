//
//  BOJ_2753.swift
//  Algorithm
//
//  Created by Theodore's iMac on 2020/06/23.
//  Copyright © 2020 Sample. All rights reserved.
//

import Foundation

class BOJ_2753 {
    func solve() {
        
        let a = readLine()
        let intA : Int = Int(a!)!
        
        if intA % 4 == 0 && ( intA % 100 != 0 || intA % 400 == 0) {
            print(1)
        } else {
            print(0)
        }
    }
}
