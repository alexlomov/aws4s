package org.aws4s.kms

import io.circe.Decoder
import org.aws4s.core.ParamValidator

case class Plaintext(raw: Blob)
    extends KmsParam[Blob](
      Plaintext.name,
      ParamValidator.sizeInRangeInclusive(1, 4096)
    )

object Plaintext {
  val name: String = "Plaintext"

  implicit val decoder: Decoder[Plaintext] =
    Decoder[Blob] map Plaintext.apply
}
