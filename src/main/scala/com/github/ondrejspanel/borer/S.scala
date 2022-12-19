package com.github.ondrejspanel.borer

import io.bullet.borer._
import io.bullet.borer.derivation.MapBasedCodecs._

object S {

  object T {
    implicit val encoder: Encoder[T] = deriveEncoder
  }

  case class T(grid: Double = 10.0)

  object SD {
    implicit val encoder: Encoder[SD] = deriveEncoder
  }
  case class SD(
      enable: Boolean,
  )

  object P {
    implicit val encoder: Encoder[P] = deriveEncoder

    def default: P = P(
      genders = Seq(),
    )
  }

  case class P(
      genders: Seq[String] = Seq(),
  )

  object B {
    implicit val encoder: Encoder[B] = deriveEncoder
  }
  case class B(
      accumulation: Double,
      multiplier: Double,
      subvention: Double,
      randomBase: Int
  )

  object C {

    implicit val encoder: Encoder[C] = deriveEncoder
  }

  case class C(
      t: T = T(),
      sd: SD = SD(enable = false),
      min: Int = 1,
      max: Int = 1,
      until: String = "",
      randomSeed: Int = 0,
      emptyBorder: Double = 100,
      ps: P = P.default,
      labourPrice: Double = 10.0,
      macroCharge: Double = 1.0,
      buildInputs: Map[String, B] = Map(),
      minLackToBuild: Double,
      minBuildShare: Double,
      comBuildMult: Double,
      outputFactor: Int,
  )
}
