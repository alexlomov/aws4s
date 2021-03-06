package org.aws4s.sqs

import cats.effect.Effect
import org.aws4s.core.{CommandPayload, Param}

private[sqs] case class DeleteMessage[F[_]: Effect](
    q:             Queue,
    receiptHandle: ReceiptHandle
) extends SqsCommand[F, Unit] {

  override val action = "DeleteMessage"

  override val params: List[Param[String]] =
    CommandPayload.params(receiptHandle)()
}
